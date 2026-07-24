Brain Tumor Classification App (Ứng dụng Phân loại U não)

Đây là một project Android demo sử dụng mô hình học máy (Machine Learning) để nhận diện và phân loại u não dựa trên hình ảnh chụp MRI.

Tính năng chính

Cho phép người dùng chọn ảnh MRI từ thư viện (Gallery) hoặc chụp từ Camera.

Sử dụng mô hình AI đã được huấn luyện để dự đoán và phân loại khối u.

Kết quả dự đoán trả về nhanh chóng do mô hình được chạy trực tiếp trên thiết bị (Offline).

Công nghệ sử dụng

Ngôn ngữ/Môi trường: Java, Android Studio.

Core AI: TensorFlow Lite. Mô hình (model.tflite) đã được tích hợp sẵn trong thư mục app/src/main/ml/.

Build System: Gradle (Kotlin DSL).

Hướng dẫn cài đặt

Clone repository này hoặc tải mã nguồn về máy.

Mở Android Studio, chọn Open an existing project và trỏ tới thư mục BrainTumorDemoApp.

Đợi Android Studio tải các dependencies và sync Gradle hoàn tất.

Kết nối thiết bị Android thật qua cáp USB hoặc mở máy ảo (Emulator).

Nhấn nút Run (biểu tượng nút Play màu xanh) để cài đặt app lên máy.

Lưu ý

Mô hình AI trong ứng dụng này mang tính chất demo và nghiên cứu học thuật. Vui lòng không sử dụng nó để thay thế cho các chẩn đoán y khoa thực tế từ bác sĩ chuyên môn.
