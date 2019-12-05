package com.sheemee.histore.native_ability;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import android.content.Context;
import android.os.Vibrator;


public class NativeAbilityPlugin implements MethodCallHandler {

  private final Vibrator vibrator;
  private static final String CHANNEL = "native_ability";

  private NativeAbilityPlugin(Registrar registrar) {
    this.vibrator = (Vibrator) registrar.context().getSystemService(Context.VIBRATOR_SERVICE);
  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), CHANNEL);
    channel.setMethodCallHandler(new NativeAbilityPlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if (call.method.equals("vibrate")) {
      if (this.vibrator.hasVibrator()) {
        this.vibrator.vibrate(15);
      }
    } else {
      result.notImplemented();
    }
  }
}
