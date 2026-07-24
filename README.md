🧠 Brain Tumor Classification - Android App

Dự án này là một ứng dụng Android sử dụng công nghệ Học máy (Machine Learning) để nhận diện và phân loại u não dựa trên hình ảnh chụp cộng hưởng từ (MRI). Ứng dụng được thiết kế nhằm mục đích nghiên cứu, học thuật và demo khả năng tích hợp mô hình AI trực tiếp lên thiết bị di động (On-device AI).

✨ Tính năng chính

Tải ảnh từ thư viện (Gallery): Người dùng có thể dễ dàng chọn các bức ảnh MRI đã được lưu sẵn trong máy.

Chụp ảnh trực tiếp (Camera): Hỗ trợ sử dụng camera của thiết bị để chụp lại phim/ảnh MRI và phân tích ngay lập tức.

Xử lý ngoại tuyến (Offline Inference): Mô hình AI được tích hợp trực tiếp vào ứng dụng, cho phép nhận diện và phân loại khối u trong thời gian thực mà không cần kết nối Internet.

Giao diện trực quan: Giao diện đơn giản, thân thiện, trả về kết quả dự đoán và độ tin cậy (confidence score) một cách rõ ràng.

🛠 Công nghệ và Công cụ sử dụng

Ngôn ngữ lập trình: Java

Môi trường phát triển: Android Studio

Trí tuệ nhân tạo (Core AI): TensorFlow Lite (TFLite)

Hệ thống Build: Gradle (Kotlin DSL - build.gradle.kts)

📦 Cấu trúc dự án

Một số thành phần quan trọng trong mã nguồn:

app/src/main/java/com/example/braintumordemoapp/: Chứa mã nguồn Java xử lý logic UI và gọi mô hình AI (MainActivity.java).

app/src/main/ml/: Thư mục chứa mô hình máy học đã được huấn luyện và tối ưu hóa cho di động (model.tflite).

app/src/main/res/: Chứa các tài nguyên giao diện như layout (activity_main.xml), hình ảnh, màu sắc và chuỗi ngôn ngữ.

build.gradle.kts: Cấu hình dependencies và thông tin build của ứng dụng.

🚀 Hướng dẫn cài đặt và chạy thử

Để chạy dự án này trên máy tính của bạn, vui lòng làm theo các bước sau:

Yêu cầu hệ thống:

Android Studio (phiên bản mới nhất được khuyến nghị).

Máy ảo Android (Emulator) hoặc thiết bị Android thật chạy hệ điều hành Android 6.0 (API level 23) trở lên.

Các bước thực hiện:

Clone Repository về máy của bạn:

git clone https://github.com/luongpham1010/tumor-classification-on-android-app.git


Mở Android Studio.

Chọn File > Open và điều hướng đến thư mục BrainTumorDemoApp vừa tải về.

Đợi Android Studio hoàn tất việc tải các thư viện (dependencies) và đồng bộ (sync) Gradle.

Kết nối điện thoại Android của bạn qua USB (đã bật chế độ USB Debugging) hoặc khởi động máy ảo (AVD).

Nhấn nút Run (Biểu tượng tam giác màu xanh) trên thanh công cụ hoặc nhấn Shift + F10 để build và cài đặt ứng dụng.

🧠 Thông tin về Mô hình AI (Model)

Mô hình học sâu (Deep Learning) được huấn luyện trước trên tập dữ liệu ảnh MRI u não.

Định dạng mô hình đã được chuyển đổi sang .tflite để tối ưu hóa về dung lượng và tốc độ xử lý trên vi xử lý của các thiết bị ARM/Di động.

Mô hình được nhúng tự động thông qua tính năng ML Model Binding của Android Studio.

⚠️ Tuyên bố miễn trừ trách nhiệm y tế (Disclaimer)

Mô hình trí tuệ nhân tạo và ứng dụng này CHỈ MANG TÍNH CHẤT DEMO VÀ PHỤC VỤ MỤC ĐÍCH HỌC THUẬT/NGHIÊN CỨU.
Ứng dụng không phải là một thiết bị y tế được chứng nhận và không được phép sử dụng để thay thế cho chẩn đoán, tư vấn, hoặc phương pháp điều trị của các bác sĩ, chuyên gia y tế có chuyên môn. Mọi quyết định liên quan đến sức khỏe cần phải được thông qua sự thăm khám tại các cơ sở y tế hợp pháp.
