DESCRIPTION = "2.6 Linux Kernel for IGEP based platforms"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE_igep00x0 = "igep00x0"

inherit kernel kernel-arch

PR = "r1"
KV = "v${PV}-2"

SRC_URI = "git://git.isee.biz/pub/scm/linux-omap-2.6.git;protocol=git;tag=${KV};branch=linux-2.6.37.y \
	file://0136621a974bb450b21683088723721364ec8631.patch \
	"

do_configure() {
	rm -f ${S}/.config || true
	oe_runmake igep00x0_defconfig
}

S = "${WORKDIR}/git"
