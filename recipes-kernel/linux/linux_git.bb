inherit kernel

COMPATIBLE_MACHINE = "igep00x0"

DESCRIPTION = "mainline Linux kernel for TI processors - IGEP board"
SECTION = "kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# Don't make this the default kernel, right now it is only for testing purposes
DEFAULT_PREFERENCE = "-1"

PV = "3.7+git${SRCPV}"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "b"

SRCREV = "${AUTOREV}"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git"
SRC_URI += "file://defconfig"

S = "${WORKDIR}/git"
