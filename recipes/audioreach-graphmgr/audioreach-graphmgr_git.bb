SUMMARY = "AudioReach Graph Manager"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphmgr.git;protocol=https;branch=master"
SRC_URI     += "file://agm_server.service"
SRC_URI     += "file://agm-dbus.conf"
S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 tinyalsa audioreach-graphservices dbus audioreach-conf"
EXTRA_OECONF += "--with-glib --with-syslog"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_install:append () {
    install -m 0644 ${WORKDIR}/agm_server.service -D ${D}${sysconfdir}/systemd/system/agm_server.service
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln -sf /etc/systemd/system/agm_server.service \
                      ${D}/etc/systemd/system/multi-user.target.wants/agm_server.service
    install -m 0644 ${WORKDIR}/agm-dbus.conf -D ${D}${sysconfdir}/dbus-1/system.d/agm-dbus.conf
}
SYSTEMD_SERVICE:${PN} = "agm_server.service"
RM_WORK_EXCLUDE += "${PN}"

inherit autotools pkgconfig
