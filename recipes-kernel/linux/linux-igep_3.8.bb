DESCRIPTION = "Linux kernel for IGEP PROCESSOR BOARDS (device tree)"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "igep0033"

DEFAULT_PREFERENCE = "-1"

# Pick up shared functions
inherit kernel
require linux-igep.inc

S = "${WORKDIR}/git"

BRANCH = "linux-3.8.y"

KERNEL_DEVICETREE_ti33x = "\
	arch/arm/boot/dts/am335x-base0033.dts \
	arch/arm/boot/dts/am335x-boneblack.dts \
"

# This commit corresponds to tag v3.8.13-0
SRCREV = "7716998dc39f4c734d7cf0e44e7f4f38297b4c46"

PR = "r0"
PV = "3.8.13-0"

SRC_URI = "git://git.isee.biz/pub/scm/linux-omap-2.6.git;protocol=git;branch=${BRANCH} "

