# 🚀 AUTO-IT: Selenium + AutoIT File Upload Automation

> **Breaking the barriers between web automation and desktop interactions** 🌐➡️🖥️

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com)
[![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://selenium.dev)
[![AutoIT](https://img.shields.io/badge/AutoIT-1C4E80?style=for-the-badge&logo=windows&logoColor=white)](https://www.autoitscript.com)
[![TestNG](https://img.shields.io/badge/TestNG-FF6B35?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org)

## 🎯 What's This About?

Ever tried uploading files with Selenium and hit that **annoying Windows file dialog** that Selenium just can't touch? 😤

**This project solves that!** 

We combine **Selenium WebDriver** with **AutoIT** to handle file uploads seamlessly - no more manual interventions!

## ⚡ Quick Demo

```java
// 1. Selenium clicks upload button
driver.findElement(By.cssSelector("button")).click();

// 2. Windows dialog appears (Selenium stops working here 😵)

// 3. AutoIT takes over and handles the dialog! 🎉
Runtime.getRuntime().exec("path/to/AutoIT-script.exe");
```

## 🛠️ Tech Stack

- **Java** - Core programming language
- **Selenium WebDriver** - Web automation
- **AutoIT** - Windows GUI automation
- **TestNG** - Testing framework
- **Maven** - Dependency management

## 🚀 Getting Started

### Prerequisites
- Java 8+
- Chrome Browser
- AutoIT installed

### Installation

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/AUTO-IT.git
   cd AUTO-IT
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Download AutoIT**
   - Visit [AutoIT Downloads](https://www.autoitscript.com/site/autoit/downloads/)
   - Install AutoIT (includes SciTE editor)

## 📝 How It Works

### The Problem 🤔
```
Selenium → Click Upload → Windows Dialog Opens → 💥 STUCK!
```

### Our Solution ✅
```
Selenium → Click Upload → AutoIT Script → File Selected → Success! 🎉
```

## 🔧 AutoIT Script Example

```autoit
; Focus on file dialog
ControlFocus("Open","","Edit1")

; Set file path
ControlSetText("Open","","Edit1","C:\path\to\your\file.png")

; Click Open button
ControlClick("Open","","Button1")
```

## 📁 Project Structure

```
AUTO-IT/
├── src/main/java/com/example/
│   ├── AutoIT.java          # Main automation class
│   └── windowPopUP.java     # Window popup handling
├── pom.xml                  # Maven dependencies
└── README.md               # You are here! 📍
```

## 🎯 Use Cases

- ✅ File uploads on web applications
- ✅ Handling authentication popups
- ✅ Windows system notifications
- ✅ Any OS-level dialog automation


## ⭐ Show Your Support

If this project helped you, please give it a ⭐! It means a lot to us.

---

<div align="center">
  <strong>Made with ❤️ for the automation community</strong>
</div>
