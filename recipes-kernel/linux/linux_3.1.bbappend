# Customization for IGEP boards

FILESEXTRAPATHS := "${THISDIR}/${PN}-${PV}"
COMPATIBLE_MACHINE_igep0020 = "(igep0020)"

PRINC = "2"

# 05/10/2011
#SRCREV_pn-${PN} = "22ad4e035cbf4df1fc6286e989aee32b5dc51720"

# 2011/10/11
SRCREV_pn-${PN} = "89b7a0631ff7d957249b0dbe825145a8306c2879"

SRC_URI = "git://git.igep.es/pub/scm/linux-omap-2.6.git;protocol=git \
           \
           file://madc/0001-Enabling-Hwmon-driver-for-twl4030-madc.patch \
           file://madc/0002-mfd-twl-core-enable-madc-clock.patch \
           file://sgx/0001-ARM-L2-Add-and-export-outer_clean_all.patch \
           \
           file://omap3isp/0001-drivers-media-do-not-use-EXTRA_CFLAGS.patch \
           file://omap3isp/0002-omap3isp-Don-t-accept-pipelines-with-no-video-source.patch \
           file://omap3isp/0003-omap3isp-queue-fail-QBUF-if-user-buffer-is-too-small.patch \
           file://omap3isp/0004-omap3isp-Move-platform-data-definitions-from-isp.h-t.patch \
           file://omap3isp/0005-omap3isp-Don-t-fail-streamon-when-the-sensor-doesn-t.patch \
           file://omap3isp/0006-omap3isp-video-Avoid-crashes-when-pipeline-set-strea.patch \
           file://omap3isp/0007-omap3isp-Move-media_entity_cleanup-from-unregister-t.patch \
           file://omap3isp/0008-omap3isp-Move-_init_entities-functions-to-the-init-c.patch \
           file://omap3isp/0009-omap3isp-Add-missing-mutex_destroy-calls.patch \
           file://omap3isp/0010-omap3isp-Fix-memory-leaks-in-initialization-error-pa.patch \
           file://omap3isp/0011-omap3isp-ccdc-remove-redundant-operation.patch \
           file://omap3isp/0012-omap3isp-video-Split-format-info-bpp-field-into-widt.patch \
           file://omap3isp/0013-omap3isp-csi2-Add-V4L2_MBUS_FMT_YUYV8_2X8-support.patch \
           file://omap3isp/0014-omap3isp-ccdc-Remove-support-for-interlaced-data-and.patch \
           file://omap3isp/0015-omap3isp-ccdc-Remove-ispccdc_syncif-structure.patch \
           file://omap3isp/0016-omap3isp-ccdc-Add-YUV-input-formats-support.patch \
           file://omap3isp/0017-omap3isp-configure-ccdc-and-add-bt656-support.patch \
           file://omap3isp/0025-omap3isp-ccdc-Add-interlaced-field-mode-to-platform-.patch \
           \
           file://tvp5150/0018-tvp5150-Add-constants-for-PAL-and-NTSC-video-standar.patch \
           file://tvp5150/0019-tvp5150-Add-video-format-registers-configuration-val.patch \
           file://tvp5150/0020-tvp5150-Migrate-to-media-controller-framework-and-ad.patch \
           file://tvp5150/0021-tvp5150-compile-fixes-and-added-missing-entity_clean.patch \
           \
           file://igep/0001-twl4030-disable-voice-if.patch \
           file://igep/0022-exp-igep0022-add-tvp5151-support.patch \
           file://igep/0023-igep00x0-fix-camera-platform-data.patch \
           file://igep/0027-omap3isp-bug-fixes.patch \
           \
           file://rs485/0001-omap-serial-add-RS-485-standard-support.patch \
           file://rs485/0002-omap-serial-Fix-bug-when-using-rs485-mode.patch \
           file://rs485/0003-omap-serial-Fix-bug-when-transmitting-more-than-16-b.patch \
           \
           file://defconfig \
          "

