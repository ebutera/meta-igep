DESCRIPTION = "Mainline Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "zImage"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

COMPATIBLE_MACHINE = "igep00x0"

KERNEL_DEVICETREE = "\
	arch/arm/boot/dts/omap3-igep0020.dts \
	arch/arm/boot/dts/omap3-igep0030.dts \
"

# Don't make this the default kernel, right now it is only for testing purposes
DEFAULT_PREFERENCE = "-1"

PR = "r1"
PV = "3.10+git${SRCPV}"

# Set autorev for development purposes
SRCREV = "${AUTOREV}"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git"

do_configure() {
	oe_runmake omap2plus_defconfig
}

S = "${WORKDIR}/git"
