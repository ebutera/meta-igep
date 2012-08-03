DESCRIPTION = "ISEE bootloader for IGEP based platforms"
HOMEPAGE = "http://www.isee.biz"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://lib/board.c;beginline=19;endline=32;md5=6120559432ceee352e4ddc8961780fb7"
SECTION = "bootloader"

VER = "${PV}-2"
PR = "r2"

SRC_URI = "git://git.isee.biz/pub/scm/igep-x-loader.git;protocol=git;tag=release-${VER}"

COMPATIBLE_MACHINE = "igep00x0"


do_compile() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS

	# Ensure signGP program is built for host machine
	${BUILD_CC} contrib/signGP.c -o contrib/signGP

	oe_runmake CROSS_COMPILE=${TARGET_PREFIX} ${MACHINE}_config
	oe_runmake CROSS_COMPILE=${TARGET_PREFIX}
	${S}/contrib/signGP x-load.bin
}

do_install() {
	install -d ${D}/boot
	cp ${S}/x-load.bin.ift ${D}/boot/MLO-${VER}
	ln -sf MLO-${VER} ${D}/boot/MLO
}

FILES_${PN} = "/boot"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"
