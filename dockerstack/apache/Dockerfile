FROM httpd:2.4.41

LABEL maintainer="Domenico Briganti <domenico.brianti@kalpa.it>"

RUN echo "LoadModule proxy_module modules/mod_proxy.so" >> /usr/local/apache2/conf/httpd.conf && \
    echo "LoadModule proxy_http_module modules/mod_proxy_http.so" >> /usr/local/apache2/conf/httpd.conf && \
    echo "LoadModule proxy_balancer_module modules/mod_proxy_balancer.so" >> /usr/local/apache2/conf/httpd.conf && \
    echo "LoadModule lbmethod_byrequests_module modules/mod_lbmethod_byrequests.so" >> /usr/local/apache2/conf/httpd.conf && \
    echo "LoadModule socache_shmcb_module modules/mod_socache_shmcb.so" >> /usr/local/apache2/conf/httpd.conf && \
    echo "LoadModule slotmem_shm_module modules/mod_slotmem_shm.so" >> /usr/local/apache2/conf/httpd.conf && \
    echo "Include conf/extra/httpd-default.conf" >> /usr/local/apache2/conf/httpd.conf 

COPY httpd-default.conf /usr/local/apache2/conf/extra/httpd-default.conf

