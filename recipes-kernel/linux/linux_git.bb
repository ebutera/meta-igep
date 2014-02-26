DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

COMPATIBLE_MACHINE = "(igep0020|igep0030|igep0033)"

KERNEL_DEVICETREE_igep0020 = "\
	arch/arm/boot/dts/omap3-igep0020.dts \
"

KERNEL_DEVICETREE_igep0030 = "\
	arch/arm/boot/dts/omap3-igep0030.dts \
"

KERNEL_DEVICETREE_igep0033 = "\
	arch/arm/boot/dts/am335x-base0033.dts \
"

# Don't make this the default kernel, right now it is only for testing purposes
DEFAULT_PREFERENCE = "-1"

PR = "r0"
PV = "3.14-rc4+git${SRCPV}"

# This commit corresponds to tag 3.14-rc4
SRCREV = "cfbf8d4857c26a8a307fb7cd258074c9dcd8c691"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git \
	file://default.cfg \
	"

do_configure() {
	# Merge default configuration with config fragments
	${S}/scripts/kconfig/merge_config.sh -m -r ${S}/arch/arm/configs/omap2plus_defconfig ${WORKDIR}/default.cfg
	oe_runmake oldconfig
}

S = "${WORKDIR}/git"
