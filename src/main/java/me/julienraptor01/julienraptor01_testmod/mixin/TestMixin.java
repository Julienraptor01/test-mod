// mixin into DamageEnchantment class and make canAccept method and isAcceptableItem method return true
package me.julienraptor01.julienraptor01_testmod.mixin;

import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.item.ItemStack;

@Mixin(DamageEnchantment.class)
public class TestMixin {
    @Inject(at = @At("HEAD"), method = "isAcceptableItem", cancellable = true)
    private void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(true);
    }

    @Inject(at = @At("HEAD"), method = "canAccept", cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}