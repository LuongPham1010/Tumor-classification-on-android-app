# 🧠 Brain Tumor Classification - Android App

Ứng dụng Android sử dụng **Học máy (Machine Learning)** để nhận diện và phân loại u não dựa trên hình ảnh chụp cộng hưởng từ (MRI). Ứng dụng được xây dựng nhằm mục đích **nghiên cứu, học thuật** và trình diễn khả năng tích hợp mô hình AI trực tiếp lên thiết bị di động (**On-device AI**).

---

## ✨ Tính năng chính

- **📁 Tải ảnh từ thư viện (Gallery)** — Người dùng chọn ảnh MRI đã có sẵn trong thiết bị để đưa vào ứng dụng phân tích.
- **⚡ Xử lý ngoại tuyến (Offline Inference)** — Mô hình AI được nhúng trực tiếp vào ứng dụng, cho phép nhận diện và phân loại khối u mà không cần kết nối Internet, đảm bảo tính bảo mật và riêng tư cho dữ liệu người dùng.
- **🖥️ Giao diện trực quan** — Giao diện đơn giản, thân thiện, gồm nút chọn ảnh và nút dự đoán (Predict), trả về nhãn phân loại rõ ràng, dễ hiểu.

> ℹ️ **Lưu ý:** Phiên bản hiện tại của mã nguồn **chưa hỗ trợ chụp ảnh trực tiếp bằng Camera** — ứng dụng chỉ nhận ảnh thông qua việc chọn từ thư viện thiết bị (`Intent.ACTION_GET_CONTENT`). Đây là hướng phát triển có thể bổ sung trong tương lai.

---

## 🛠 Công nghệ và công cụ sử dụng

| Thành phần | Công nghệ |
|---|---|
| Ngôn ngữ lập trình | Java |
| Môi trường phát triển | Android Studio |
| AI Core | TensorFlow Lite (TFLite) |
| Hệ thống Build | Gradle (Kotlin DSL - `build.gradle.kts`) |

---

## 📦 Cấu trúc dự án

```
app/src/main/java/com/example/braintumordemoapp/  → Mã nguồn Java: logic giao diện, xử lý luồng ảnh, gọi mô hình AI (MainActivity.java)
app/src/main/ml/                                   → Mô hình máy học đã huấn luyện, tối ưu cho thiết bị di động (model.tflite)
app/src/main/res/                                  → Tài nguyên giao diện (layout, icon, màu sắc, chuỗi ngôn ngữ)
build.gradle.kts                                   → Cấu hình dependencies và thông tin build
```

### Luồng hoạt động chính (MainActivity.java)

1. Người dùng nhấn nút **Select** → mở trình chọn ảnh từ thư viện (`ACTION_GET_CONTENT`, kiểu `image/*`).
2. Ảnh được lấy về dưới dạng `Bitmap` và hiển thị lên `ImageView`.
3. Người dùng nhấn nút **Predict** → ảnh được resize về `150x150`, đưa vào mô hình TFLite (`Model.newInstance`) để suy luận.
4. Kết quả được ánh xạ sang 1 trong 4 nhãn: `glioma`, `meningioma`, `no tumor`, `pituitary` và hiển thị lên màn hình.

---

## 🚀 Hướng dẫn cài đặt và chạy thử

### Yêu cầu hệ thống

- Đã cài đặt **Android Studio** (khuyến nghị phiên bản mới nhất)
- Máy ảo Android (**Emulator**) hoặc thiết bị Android thật chạy **Android 6.0 (API level 23)** trở lên

### Các bước thực hiện

1. Clone repository về máy tính của bạn:

   ```bash
   git clone https://github.com/luongpham1010/tumor-classification-on-android-app.git
   ```

2. Mở **Android Studio**.
3. Chọn **File > Open** và điều hướng đến thư mục `BrainTumorDemoApp` vừa tải về.
4. Đợi Android Studio hoàn tất tải các thư viện (dependencies) và đồng bộ (sync) Gradle.
5. Kết nối điện thoại Android qua cáp USB (đảm bảo đã bật **USB Debugging** trong Tùy chọn nhà phát triển) hoặc khởi động máy ảo (AVD).
6. Nhấn nút **Run** (biểu tượng tam giác màu xanh) hoặc nhấn **Shift + F10** để build và cài đặt ứng dụng lên thiết bị.

---

## 🧠 Thông tin về mô hình AI

- Mô hình học sâu (Deep Learning) được huấn luyện trước (pre-trained) trên một tập dữ liệu lớn các hình ảnh MRI về u não.
- Mô hình được chuyển đổi sang chuẩn **`.tflite`** (TensorFlow Lite) để tối ưu về dung lượng file và tốc độ xử lý (inference speed) trên vi xử lý ARM/Mobile.
- Mô hình được nhúng và liên kết tự động thông qua tính năng **ML Model Binding** tích hợp sẵn của Android Studio, giúp việc gọi model từ mã Java trở nên gọn nhẹ.
- Ảnh đầu vào được resize về kích thước `150x150x3` trước khi đưa vào mô hình.
- Đầu ra là 1 trong 4 lớp: `glioma`, `meningioma`, `no tumor`, `pituitary`.

---

## 🗺️ Hướng phát triển tiếp theo (Roadmap)

- [ ] Bổ sung chức năng chụp ảnh trực tiếp bằng Camera
- [ ] Hiển thị độ tin cậy (Confidence Score) kèm theo kết quả dự đoán
- [ ] Cải thiện giao diện người dùng (UI/UX)

---

## ⚠️ Tuyên bố miễn trừ trách nhiệm y tế

> Mô hình trí tuệ nhân tạo và ứng dụng này **chỉ mang tính chất demo và phục vụ mục đích học thuật/nghiên cứu**.
>
> Ứng dụng **không phải là một thiết bị y tế được chứng nhận** và không được phép sử dụng để thay thế cho chẩn đoán y khoa chuyên nghiệp, tư vấn hoặc phương pháp điều trị của bác sĩ, chuyên gia y tế có chuyên môn. Mọi quyết định liên quan đến sức khỏe và chẩn đoán bệnh lý cần được thực hiện và thông qua sự thăm khám tại các cơ sở y tế hợp pháp. Tác giả không chịu trách nhiệm cho bất kỳ quyết định y tế nào được đưa ra dựa trên kết quả của ứng dụng này.
