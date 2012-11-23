inherit kernel

COMPATIBLE_MACHINE = "igep00x0"

DESCRIPTION = "Linux kernel for TI processors - IGEP board"
SECTION = "kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PV = "3.2"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "f"

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
            file://sakoman/0001-cpufreq-OMAP-cleanup-for-multi-SoC-support-move-into.patch \
            file://sakoman/0002-cpufreq-OMAP-Add-SMP-support-for-OMAP4.patch \
            file://sakoman/0003-cpufreq-OMAP-Enable-all-CPUs-in-shared-policy-mask.patch \
            file://sakoman/0004-cpufreq-OMAP-notify-even-with-bad-boot-frequency.patch \
            file://sakoman/0005-cpufreq-OMAP-move-clk-name-decision-to-init.patch \
            file://sakoman/0006-cpufreq-OMAP-deny-initialization-if-no-mpudev.patch \
            file://sakoman/0007-cpufreq-OMAP-dont-support-freq_table.patch \
            file://sakoman/0008-cpufreq-OMAP-only-supports-OPP-library.patch \
            file://sakoman/0009-cpufreq-OMAP-put-clk-if-cpu_init-failed.patch \
            file://sakoman/0010-cpufreq-OMAP-fix-freq_table-leak.patch \
            file://sakoman/0011-cpufreq-OMAP-fixup-for-omap_device-changes-include-l.patch \
            file://sakoman/0012-omap-mmc-Adjust-dto-to-eliminate-timeout-errors.patch \
            \
            file://defconfig"

S = "${WORKDIR}/git"

