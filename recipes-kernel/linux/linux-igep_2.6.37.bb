DESCRIPTION = "2.6 Linux Kernel for IGEP based platforms"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE_igep00x0 = "igep00x0"

inherit kernel kernel-arch

PR = "r4"
KV = "${PV}-4"

SRC_URI = "http://downloads.isee.biz/pub/releases/linux_kernel/v${KV}/linux-omap-${KV}.tar.gz"

SRC_URI[md5sum] = "f76ad40bd054c16fef4023cf1bce5c50"
SRC_URI[sha256sum] = "8977643d6ab6412d77cd1884c854d070f4785d54880fa3100fa07c3a0b649a4d"

do_configure() {
	rm -f ${S}/.config || true
	oe_runmake igep00x0_defconfig
}

S = "${WORKDIR}/linux-omap-${KV}"
