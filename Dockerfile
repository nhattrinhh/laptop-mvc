# Stage 1: Giai đoạn Build (Sử dụng Maven và JDK 17)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy file cấu hình Maven trước để tận dụng cache của Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn vào container
COPY src ./src

# Đóng gói ứng dụng thành file .jar (Bỏ qua chạy Unit Test để build nhanh hơn)
RUN mvn clean package -DskipTests

# Stage 2: Giai đoạn Chạy (Sử dụng JRE nhẹ hơn để tiết kiệm bộ nhớ VPS)
FROM openjdk:17-jdk-slim
WORKDIR /app

# SỬA LỖI TẠI ĐÂY: Dùng dấu "=" thay vì ":"
# Lấy file .jar đã build từ Stage 1 sang Stage 2
COPY --from=build /app/target/*.jar app.jar

# Mở cổng 8080 (Cổng mặc định của Spring Boot)
EXPOSE 8080

# Lệnh khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]