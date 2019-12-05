import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import '../lib/native_ability.dart';

void main() {
  const MethodChannel channel = MethodChannel('native_ability');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await NativeAbility.platformVersion, '42');
  });
}
