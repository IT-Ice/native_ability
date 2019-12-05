import 'dart:async';

import 'package:flutter/services.dart';

class NativeAbility {
  static const MethodChannel _channel =
      const MethodChannel('native_ability');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<void> vibrate() async {
    await _channel.invokeMethod('vibrate');
  }

}
