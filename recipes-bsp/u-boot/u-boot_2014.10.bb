require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

RPROVIDES_${PN} = "virtual/bootloader"

COMPATIBLE_MACHINE = "(igep0020|igep0030|igep0033)"

# This revision corresponds to the tag "v2014.10"
SRCREV = "c43fd23cf619856b0763a64a6a3bcf3663058c49"

PR = "r0"

SRC_URI = "git://git.denx.de/u-boot.git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
