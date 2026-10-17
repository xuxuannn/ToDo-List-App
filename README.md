# ToDo List Android

![Android](https://img.shields.io/badge/Android-API%2024%2B-3DDC84?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-8%20compatibility-ED8B00?logo=openjdk&logoColor=white)

## Overview

ToDo List Android is a compact task-management application built with Java and the Android Views toolkit. It demonstrates a three-screen workflow for creating, reviewing, editing, and removing tasks.

Tasks are stored in memory for the current app session. The project does not currently include database or file persistence.

## Features

- Create tasks with a title and multiline description.
- Assign one of four categories: KIV, General, Important, or Urgent.
- Track task status as Pending, In Progress, or Completed.
- Tap an existing task to edit its details.
- Long-press a task to remove it.
- Display task details in a simple list.

## Tech Stack

- Java
- Android SDK 34; minimum SDK 24
- AndroidX AppCompat
- Material Components for Android
- XML-based Android Views
- Gradle 8.2 and Android Gradle Plugin 8.2.1

## Project Structure

```text
app/src/main/
|-- java/com/example/todolist/
|   |-- MainActivity.java      # Task list and navigation
|   |-- addNewTask.java        # Task creation form
|   |-- editTask.java          # Task editing form
|   `-- Task.java             # Task data model
|-- res/layout/                # Activity layouts
|-- res/values/                # Strings, colors, and themes
`-- AndroidManifest.xml
```

## Setup and Run

1. Install Android Studio with JDK 17 and Android SDK 34.
2. Open the repository root and allow Gradle to synchronize.
3. Select an emulator or Android device running API 24 or newer.
4. Run the `app` configuration.

Windows command-line build:

```powershell
.\gradlew.bat assembleDebug
```

macOS or Linux:

```bash
./gradlew assembleDebug
```

The debug APK is generated under `app/build/outputs/apk/debug/`.

## Assets

<p align="center">
  <img src="app/src/main/ic_launcher-playstore.png" alt="ToDo List app icon" width="160">
</p>

The repository includes Android launcher artwork. No application screenshots are currently included.

## Current Limitations

- Tasks are not retained after the app process is closed.
- The add and edit forms expect a category and status selection.
- Automated tests are limited to the generated Android test templates.

## My Contribution

I contributed to the application implementation represented in this repository, including the task model, list interactions, create/edit flows, and XML layouts. This statement is limited to the project files shown here and does not claim ownership of Android, AndroidX, Material Components, or generated Android starter assets.

---

# ToDo List Android 中文说明

## 项目简介

ToDo List Android 是一款使用 Java 和 Android Views 构建的轻量级任务管理应用。项目通过三个页面展示任务的新增、查看、编辑与删除流程。

任务目前仅保存在应用运行期间的内存中，尚未接入数据库或文件持久化。

## 实际功能

- 新增包含标题与多行描述的任务。
- 为任务选择 KIV、General、Important 或 Urgent 分类。
- 将任务状态设为 Pending、In Progress 或 Completed。
- 点击现有任务进入编辑页面。
- 长按任务将其删除。
- 在列表中显示任务的完整信息。

## 技术栈

- Java
- Android SDK 34，最低支持 SDK 24
- AndroidX AppCompat
- Material Components for Android
- XML Android Views
- Gradle 8.2 与 Android Gradle Plugin 8.2.1

## 项目结构

```text
app/src/main/
|-- java/com/example/todolist/ # 页面逻辑与任务模型
|-- res/layout/                # 页面布局
|-- res/values/                # 字符串、颜色与主题
`-- AndroidManifest.xml        # 应用配置
```

## 配置与运行

1. 安装 Android Studio、JDK 17 与 Android SDK 34。
2. 使用 Android Studio 打开项目根目录并等待 Gradle 同步。
3. 选择 API 24 或以上的模拟器或 Android 设备。
4. 运行 `app` 配置。

Windows 命令行构建：

```powershell
.\gradlew.bat assembleDebug
```

生成的调试 APK 位于 `app/build/outputs/apk/debug/`。

## 素材

项目包含 Android 启动图标素材，但目前没有应用截图。

## 当前限制

- 应用进程关闭后，任务不会保留。
- 新增与编辑表单要求用户选择分类和状态。
- 自动化测试目前仅包含 Android 模板测试。

## 我的贡献

我参与了本仓库所展示的应用实现，包括任务模型、列表交互、新增与编辑流程以及 XML 布局。此说明仅针对仓库内的项目文件，不主张拥有 Android、AndroidX、Material Components 或 Android 自动生成素材的权利。
