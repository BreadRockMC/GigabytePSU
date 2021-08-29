package io.github.breadrockmc.gigabyte.gigabytepsu.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class PSU extends Block {
    public PSU(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(random.nextInt(3) == 2){
            this.explode(world, pos, random);
        }
    }

    protected void explode(ServerWorld world, BlockPos pos, Random random){
        world.removeBlock(pos, false);
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), random.nextFloat()*6f, Explosion.DestructionType.BREAK);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 15;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 9f/16f, 1f);
    }
}
