# Support for device tree generation
FILES_kernel-devicetree = "/boot/devicetree*"
KERNEL_DEVICETREE_FLAGS ?= "-R 8 -p 0x3000"

python __anonymous () {
    devicetree = d.getVar("KERNEL_DEVICETREE", True) or ''
    if devicetree:
	depends = d.getVar("DEPENDS", True)
	d.setVar("DEPENDS", "%s dtc-native" % depends)
	packages = d.getVar("PACKAGES", True)
	d.setVar("PACKAGES", "%s kernel-devicetree" % packages)
}

do_configure() {
	oe_runmake omap2plus_defconfig
}

do_install_append() {
	if test -n "${KERNEL_DEVICETREE}"; then
		for DTS_FILE in ${KERNEL_DEVICETREE}; do
			if [ ! -f ${DTS_FILE} ]; then
				echo "Warning: ${DTS_FILE} is not available!"
				continue
			fi
			DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
			DTB_NAME=`echo ${KERNEL_IMAGE_BASE_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
			DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
			# Note the required -@ option; it is not part of the upstream dtc, so it's a DT overlay specific
			# patch that enables it. The linux-igep kernel has the patch already applied on it’s internal dtc
			# compiler copy, as well as the Yocto meta-igep layer,
			# Original invocation was :
			#   dtc -I dts -O dtb ${KERNEL_DEVICETREE_FLAGS} -o ${DTS_BASE_NAME} ${DTS_FILE}
			dtc -I dts -O dtb ${KERNEL_DEVICETREE_FLAGS} -o ${DTS_BASE_NAME} -b 0 -@ ${DTS_FILE}
			install -m 0644 ${DTS_BASE_NAME} ${D}/boot/devicetree-${DTB_SYMLINK_NAME}.dtb
		done

		# Install device tree capes plugins
		install -d ${D}/lib/firmware
		cp -fr ${S}/firmware/*dtbo ${D}/lib/firmware 
	fi
}

do_deploy_append() {
	if test -n "${KERNEL_DEVICETREE}"; then
		for DTS_FILE in ${KERNEL_DEVICETREE}; do
			if [ ! -f ${DTS_FILE} ]; then
				echo "Warning: ${DTS_FILE} is not available!"
				continue
			fi
			DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
			DTB_NAME=`echo ${KERNEL_IMAGE_BASE_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
			DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
			install -d ${DEPLOYDIR}
			install -m 0644 ${B}/${DTS_BASE_NAME} ${DEPLOYDIR}/${DTB_NAME}.dtb
			cd ${DEPLOYDIR}
			ln -sf ${DTB_NAME}.dtb ${DTB_SYMLINK_NAME}.dtb
			cd -
		done
	fi
}

PACKAGES += " kernel-firmware-capes"

FILES_kernel-firmware-capes = "/lib/firmware/*dtbo"

pkg_postinst_kernel-devicetree () {
	cd /${KERNEL_IMAGEDEST}
	for DTS_FILE in ${KERNEL_DEVICETREE}
	do
		DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
		DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
		update-alternatives --install /${KERNEL_IMAGEDEST}/${DTS_BASE_NAME}.dtb ${DTS_BASE_NAME}.dtb devicetree-${DTB_SYMLINK_NAME}.dtb ${KERNEL_PRIORITY} || true
	done
}

pkg_postrm_kernel-devicetree () {
	cd /${KERNEL_IMAGEDEST}
	for DTS_FILE in ${KERNEL_DEVICETREE}
	do
		DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
		DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
		update-alternatives --remove ${DTS_BASE_NAME}.dtb devicetree-${DTB_SYMLINK_NAME}.dtb ${KERNEL_PRIORITY} || true
	done
}
