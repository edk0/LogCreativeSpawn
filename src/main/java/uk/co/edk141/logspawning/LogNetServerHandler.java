package uk.co.edk141.logspawning;

import net.minecraft.server.NetServerHandler;
import net.minecraft.server.Packet;
import net.minecraft.server.Packet101CloseWindow;
import net.minecraft.server.Packet102WindowClick;
import net.minecraft.server.Packet106Transaction;
import net.minecraft.server.Packet107SetCreativeSlot;
import net.minecraft.server.Packet108ButtonClick;
import net.minecraft.server.Packet10Flying;
import net.minecraft.server.Packet130UpdateSign;
import net.minecraft.server.Packet14BlockDig;
import net.minecraft.server.Packet15Place;
import net.minecraft.server.Packet16BlockItemSwitch;
import net.minecraft.server.Packet18ArmAnimation;
import net.minecraft.server.Packet19EntityAction;
import net.minecraft.server.Packet202Abilities;
import net.minecraft.server.Packet250CustomPayload;
import net.minecraft.server.Packet255KickDisconnect;
import net.minecraft.server.Packet3Chat;
import net.minecraft.server.Packet7UseEntity;
import net.minecraft.server.Packet9Respawn;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;

public class LogNetServerHandler extends NetServerHandler {
    private final NetServerHandler o;
    private final LCS plugin;
    
    public LogNetServerHandler(LCS instance, NetServerHandler original) {
        super(((CraftServer)Bukkit.getServer()).getServer(), original.networkManager, original.player);
        o = original;
        plugin = instance;
    }
    
    @Override
    public CraftPlayer getPlayer() {
        return o.getPlayer();
    }
    
    @Override
    public void a() {
        o.a();
    }
    
    @Override
    public void disconnect(String s) {
        o.disconnect(s);
    }
    
    @Override
    public void a(Packet10Flying packet10flying) {
        o.a(packet10flying);
    }
    
    @Override
    public void a(double d0, double d1, double d2, float f0, float f1) {
        o.a(d0, d1, d2, f0, f1);
    }
    
    @Override
    public void teleport(Location dest) {
        o.teleport(dest);
    }
    
    @Override
    public void a(Packet14BlockDig packet14blockdig) {
        o.a(packet14blockdig);
    }
    
    @Override
    public void a(Packet15Place packet15place) {
        o.a(packet15place);
    }
    
    @Override
    public void a(String s, Object[] aobject) {
        o.a(s, aobject);
    }
    
    @Override
    public void onUnhandledPacket(Packet packet) {
        o.onUnhandledPacket(packet);
    }
    
    @Override
    public void sendPacket(Packet packet) {
        o.sendPacket(packet);
    }
    
    @Override
    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        o.a(packet16blockitemswitch);
    }
    
    @Override
    public void a(Packet3Chat packet3chat) {
        o.a(packet3chat);
    }
    
    @Override
    public void a(Packet18ArmAnimation packet18armanimation) {
        o.a(packet18armanimation);
    }
    
    @Override
    public void a(Packet19EntityAction packet19entityaction) {
        o.a(packet19entityaction);
    }
    
    @Override
    public void a(Packet255KickDisconnect packet255kickdisconnect) {
        o.a(packet255kickdisconnect);
    }
    
    @Override
    public int lowPriorityCount() {
        return o.lowPriorityCount();
    }
    
    @Override
    public void sendMessage(String s) {
        o.sendMessage(s);
    }
    
    @Override
    public String getName() {
        return o.getName();
    }
    
    @Override
    public void a(Packet7UseEntity packet7useentity) {
        o.a(packet7useentity);
    }
    
    @Override
    public void a(Packet9Respawn packet9respawn) {
        o.a(packet9respawn);
    }
    
    @Override
    public void handleContainerClose(Packet101CloseWindow packet101closewindow) {
        o.handleContainerClose(packet101closewindow);
    }
    
    @Override
    public void a(Packet102WindowClick packet102windowclick) {
        o.a(packet102windowclick);
    }
    
    @Override
    public void a(Packet108ButtonClick packet108buttonclick) {
        o.a(packet108buttonclick);
    }
    
    @Override
    public void a(Packet107SetCreativeSlot packet107setcreativeslot) {
        if (!o.player.itemInWorldManager.isCreative()) return;
        try {
            plugin.onCreativeSpawn(getPlayer(), new CraftItemStack(packet107setcreativeslot.b), packet107setcreativeslot.slot);
        } catch (Exception ex) {
            plugin.log.severe(ex.toString());
        }
        o.a(packet107setcreativeslot);
    }
    
    @Override
    public void a(Packet106Transaction packet106transaction) {
        o.a(packet106transaction);
    }
    
    @Override
    public void a(Packet130UpdateSign packet130updatesign) {
        o.a(packet130updatesign);
    }
    
    @Override
    public boolean c() {
        return o.c();
    }
    
    @Override
    public void a(Packet202Abilities packet202abilities) {
        o.a(packet202abilities);
    }
    
    @Override
    public void a(Packet250CustomPayload packet) {
        o.a(packet);
    }
}
