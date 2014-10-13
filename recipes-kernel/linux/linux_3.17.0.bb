DESCRIPTION = "Linux Kernel (IGEP Technology devices)"
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
# Set as default for following machines
DEFAULT_PREFERENCE_igep0020 = "1"
DEFAULT_PREFERENCE_igep0030 = "1"
DEFAULT_PREFERENCE_igep0033 = "1"

PR = "r0"

# This commit corresponds to tag 3.17.0
SRCREV = "bfe01a5ba2490f299e1d2d5508cbbbadd897bbe9"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git \
	file://omap2plus-delta.cfg \
	"

do_configure() {
	# Merge default configuration with config fragments
	${S}/scripts/kconfig/merge_config.sh -m -r ${S}/arch/arm/configs/omap2plus_defconfig ${WORKDIR}/omap2plus-delta.cfg
	oe_runmake oldconfig
}

do_install_append() {
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}

PACKAGES =+ "kernel-headers"
FILES_kernel-headers = "${exec_prefix}/src/linux*"

S = "${WORKDIR}/git"
