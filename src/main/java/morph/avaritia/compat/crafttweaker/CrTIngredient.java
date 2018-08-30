package morph.avaritia.compat.crafttweaker;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.item.MCItemStack;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nullable;

@MethodsReturnNonnullByDefault
public class CrTIngredient extends Ingredient {
    
    private final IIngredient ingredient;
    
    private CrTIngredient(IIngredient ingredient) {
        this.ingredient = ingredient;
    }
    
    public static Ingredient getIngredient(IIngredient ingredient) {
        return ingredient == null ? Ingredient.EMPTY : new CrTIngredient(ingredient);
    }
    
    
    @Override
    public boolean test(@Nullable ItemStack input) {
        return apply(input);
    }
    
    @Override
    public ItemStack[] getMatchingStacks() {
        return CraftTweakerMC.getItemStacks(ingredient.getItems());
    }
    
    @Override
    public boolean apply(@Nullable ItemStack input) {
        return ingredient.matches(MCItemStack.createNonCopy(input));
    }
}
