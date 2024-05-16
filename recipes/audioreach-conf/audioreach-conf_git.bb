DESCRIPTION = "AudioReach configurations"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://git@github.com/Audioreach/audioreach-conf.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
