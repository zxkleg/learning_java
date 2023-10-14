package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import xyz.xenondevs.invui.gui.Gui;

public class ShopUtils {
    public static Gui generateShopGui(){
        Gui gui = Gui.normal().build();
        return gui;
    }
    public static void generateBuyConfirmWindow(){

    }
    public static String Serialize(Component text){
        return LegacyComponentSerializer.legacySection().serialize(text);
    }
}
