package com.lousiesmods.lousiesutilities.data;

import com.lousiesmods.lousiesutilities.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class LousiesUtilitiesItemModelProvider extends ItemModelProvider
{
    public LousiesUtilitiesItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        withExistingParent("slime_locator", modLoc("item/slime_locator"));
        getBuilder("slime_locator").parent(itemGenerated).texture("layer0", "item/slime_locator");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name)
    {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
