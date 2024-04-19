FROM ubuntu:18.04 as builder
RUN apt-get update && apt-get install -y \
    tesseract-ocr \
    libtesseract-dev

FROM openjdk:17-oracle
WORKDIR /opt/target
COPY ocr-service/target/ocr-service-1.0.jar .
COPY ocr-service/src/main/java/sdt/ocr/tesseract-ocr /opt/tesseract-ocr

COPY --from=builder /usr/lib/x86_64-linux-gnu/libtesseract.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/liblept.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libgomp.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libjpeg.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libgif.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libtiff.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libwebp.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libopenjp2.* /usr/lib/
COPY --from=builder /usr/lib/x86_64-linux-gnu/libjbig.* /usr/lib/

RUN ldconfig

ENTRYPOINT ["java", "-jar", "ocr-service-1.0.jar"]
