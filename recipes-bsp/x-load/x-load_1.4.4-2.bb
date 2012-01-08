DESCRIPTION = "x-loader for IGEP based platforms"
SECTION = "bootloader"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_igep0020 = "1"
#DEFAULT_PREFERENCE_igep0030 = "1"

COMPATIBLE_MACHINE = "(igep0020)"

SRC_URI = "http://downloads.igep.es/sources/x-loader-${PV}.tar.gz"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/x-loader-${PV}"

# TODO: hack, there is no license file in archive
LIC_FILES_CHKSUM = "file://README;md5=fb7a7e60aceaa99c529b6c667dfcf474"

SRC_URI[md5sum] = "911d16c1a7c959b19f2d74628b7741df"
SRC_URI[sha256sum] = "9f6c723481bc1ac400f4181efe8a086369faf5fa48fb29099982b3a48452ee26"

do_compile () {
	unset LDFLAGS CFLAGS CPPFLAGS
	scripts/./autobuild.sh ${TARGET_PREFIX}
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0666 ${S}/autobuild/${MACHINE}/flash/x-load-ddp.bin.ift ${DEPLOY_DIR_IMAGE}/x-load-ddp-${PV}.${MACHINE}-flash.bin.ift
#	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/x-load-ddp-${PV}.${MACHINE}-flash.bin.ift

	rm -f x-load-ddp-${MACHINE}-flash.bin.ift
	ln -sf x-load-ddp-${PV}.${MACHINE}-flash.bin.ift ${DEPLOY_DIR_IMAGE}/x-load-ddp-${MACHINE}-flash.bin.ift
#	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/x-load-ddp-${MACHINE}-flash.bin.ift

	install -m 0666 ${S}/autobuild/${MACHINE}/sdcard/x-load.bin.ift ${DEPLOY_DIR_IMAGE}/x-load-${PV}.${MACHINE}-sdcard.bin.ift
#	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/x-load-${PV}.${MACHINE}-sdcard.bin.ift

	rm -f x-load-${PV}.${MACHINE}-sdcard.bin.ift
	ln -sf x-load-${PV}.${MACHINE}-sdcard.bin.ift ${DEPLOY_DIR_IMAGE}/x-load-${MACHINE}-sdcard.bin.ift
#	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/x-load-${MACHINE}-sdcard.bin.ift
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile

