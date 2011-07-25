# Customization for IGEP boards

FILESEXTRAPATHS := "${THISDIR}/${PN}-${PV}"
COMPATIBLE_MACHINE_igep0020 = "(igep0020)"

PRINC = "1"

SRC_URI += "file://igep/0001-OMAP3-igep-HACK-add-in-1GHz-OPP.patch \
           "
