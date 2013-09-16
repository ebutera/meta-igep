require recipes-bsp/u-boot/u-boot.inc

DEFAULT_PREFERENCE = "-1"
# Set as default for following machines
DEFAULT_PREFERENCE_igep00x0 = "1"
DEFAULT_PREFERENCE_igep0033 = "1"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "machine_config"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

# This revision corresponds to the tag "v2013.07-0"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "9dfd3b780193ca055a07a41c93c4da9c2fe8666f"

PR = "r1"

SRC_URI = "git://git.isee.biz/pub/scm/u-boot-arm.git;branch=u-boot-2013.07.y;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
