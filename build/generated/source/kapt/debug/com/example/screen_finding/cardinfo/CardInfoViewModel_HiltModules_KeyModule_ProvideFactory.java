// Generated by Dagger (https://dagger.dev).
package com.example.screen_finding.cardinfo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CardInfoViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static CardInfoViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(CardInfoViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final CardInfoViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CardInfoViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
