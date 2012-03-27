require recipes-kernel/linux/linux.inc

DESCRIPTION = "2.6 Linux Kernel for IGEP based platforms"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(igep0020|igep0030)"

SRC_URI = "git://git.igep.es/pub/scm/linux-omap-2.6.git;protocol=git;tag=v${PV} \
	   file://defconfig"

S = "${WORKDIR}/git"

