require recipes-kernel/linux/linux.inc

COMPATIBLE_MACHINE = "igep0020"

DESCRIPTION = "Linux kernel for TI processors - IGEP board"
KERNEL_IMAGETYPE = "uImage"

#DEFAULT_PREFERENCE = "-99"

PV = "3.2"
#SRCREV_pn-${PN} = "9e79e3e9dd9672b37ac9412e9a926714306551fe"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "e"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;tag=v3.2 \
            \
            file://omap3isp/0001-omap3isp-configure-ccdc-registers.patch \
            file://omap3isp/0002-omap3isp-add-bt656-support.patch \
            file://igep/0003-board-igep0020-add-tvp5150-support.patch \
            file://tvp5150/0004-tvp5150-Add-constants-for-PAL-and-NTSC-video-standar.patch \
            file://tvp5150/0005-tvp5150-Migrate-to-media-controller-framework-and-ad.patch \
            file://tvp5150/0006-tvp5150-compile-fixes-and-added-missing-entity_clean.patch \
            file://igep/0007-board-igep0020-fix-mux-for-tvp5150-gpio-powerdown.patch \
            file://igep/0008-board-igep0020-enable-bt656-mode.patch \
            file://igep/0009-ASoC-TWL4030-Disable-REG_VOICE_IF-by-default.patch \
            \
            file://rs485/0010-omap-serial-add-RS-485-standard-support.patch \
            file://rs485/0011-omap-serial-Fix-bug-when-using-rs485-mode.patch \
            file://rs485/0012-omap-serial-Fix-bug-when-transmitting-more-than-16-b.patch \
            \
            file://igep/0013-board-igep0020-force-twl4030-codec-registers-reset-a.patch \
            file://igep/0014-board-igep0020-use-gpmc_onenand_init-to-init-flash.patch \
            file://igep/0015-mtd-OneNAND-Fix-bufferram-management-if-chip-has-2-p.patch \
            file://igep/0016-igep0020-add-opp-init.patch \
            file://igep/0017-igep0020-fix-regulators.patch \
            file://igep/0018-omap3-Add-basic-support-for-720MHz-part.patch \
            file://igep/0019-omap3-nand-Make-board_onenand_init-visible-to-board-.patch \
            file://igep/0020-igep0020-Add-support-for-Micron-NAND-Flash-storage-m.patch \
            \
            file://defconfig"

S = "${WORKDIR}/git"

