FROM websphere-liberty
VOLUME /tmp

ARG WAR_FILE

COPY ${WAR_FILE} /config/dropins/verbweb.ear

EXPOSE 9080

ENTRYPOINT ["/opt/ibm/wlp/bin/server", "run", "defaultServer"]