# Update DTC to latest git and apply DT overlay patch
#
# Note the required -@ option; it is not part of the upstream dtc, so it's a DT
# overlay specific patch that enables it. If the patch is not applied you can
# see messages like:
#   
# bone-capemgr bone_capemgr.8: slot #4: Failed to resolve tree
# bone-capemgr bone_capemgr.8: loader: failed to load slot-4 BB-BONE-EMMC-2G:00A0 (prio 1)
# bone-capemgr bone_capemgr.8: slot #5: Failed to resolve tree
# bone-capemgr bone_capemgr.8: loader: failed to load slot-5 BB-BONELT-HDMI:00A0 (prio 1)
# bone-capemgr bone_capemgr.8: slot #6: Failed to resolve tree
# bone-capemgr bone_capemgr.8: loader: failed to load slot-6 BB-BONELT-HDMIN:00A0 (prio 2)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "27cdc1b16f86f970c3c049795d4e71ad531cca3d"

SRC_URI += "file://0001-dtc-Dynamic-symbols-fixup-support.patch"

