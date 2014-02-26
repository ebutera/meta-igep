require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

RPROVIDES_${PN} = "virtual/bootloader"

COMPATIBLE_MACHINE = "(igep0020|igep0030|igep0033)"

# This revision corresponds to the tag "v2014.01" + some fixes
SRCREV = "e7c4b68258305bbbd7dcf4ccf05d96aeb6cd134b"

PR = "r0"

SRC_URI = "git://github.com/eballetbo/u-boot.git;branch=u-boot-2014.01.y"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
