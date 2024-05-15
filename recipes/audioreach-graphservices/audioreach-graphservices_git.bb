SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6921cdd00790cae6b02ce61e60ab9e55"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 audioreach-kernel"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils --with-dummy_diag"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

PACKAGECONFIG ??= "qcom"
PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom"

inherit autotools pkgconfig
RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core \
"
