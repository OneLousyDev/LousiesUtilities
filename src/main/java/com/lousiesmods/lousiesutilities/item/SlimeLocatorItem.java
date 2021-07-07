package com.lousiesmods.lousiesutilities.item;

import com.lousiesmods.lousiesutilities.Reference;
import com.lousiesmods.lousiesutilities.handler.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SlimeLocatorItem extends Item
{
    private static final String TAG_ACTIVE = "active";

    public SlimeLocatorItem()
    {
        super(new Item.Properties().tab(Reference.CREATIVE_TAB_ITEMS).stacksTo(1));
    }

    public static boolean isActive(ItemStack stack)
    {
        final CompoundNBT itemTag = stack.getTag();
        return itemTag != null && itemTag.getBoolean(TAG_ACTIVE);
    }

    private static boolean isInSlimeChunk(ServerWorld world, Entity entity)
    {
        if (world == null || entity == null || world.getLevel().dimension() != World.OVERWORLD)
        {
            return false;
        }

        ChunkPos chunkpos = new ChunkPos(new BlockPos(entity.position().x, entity.position().y, entity.position().z));
        return SharedSeedRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, world.getSeed(), 987234911L).nextInt(10) == 0;
    }

    private static boolean update(ItemStack stack, ServerWorld world, Entity entity)
    {
        final boolean isActive = isActive(stack);
        final boolean isInSlimeChunk = isInSlimeChunk(world, entity);

        if (isActive != isInSlimeChunk)
        {
            if (isInSlimeChunk && entity instanceof ServerPlayerEntity)
            {
                entity.playSound(SoundRegistry.SLIME_LOCATOR.get(), 1F, 1F);
            }

            stack.getOrCreateTag().putBoolean(TAG_ACTIVE, isInSlimeChunk);

            return true;
        }

        return false;
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean isSelected)
    {
        if (!world.isClientSide)
        {
            update(stack, (ServerWorld) world, entity);
        }
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entityItem)
    {
        final World world = entityItem.level;

        if (!world.isClientSide)
        {
            if (update(stack, (ServerWorld) world, entityItem))
            {
                entityItem.setItem(stack);
            }
        }

        return super.onEntityItemUpdate(stack, entityItem);
    }
}
