package org.sobadfish.bedwar.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import org.sobadfish.bedwar.BedWarMain;
import org.sobadfish.bedwar.panel.DisPlayWindowsFrom;
import org.sobadfish.bedwar.panel.from.BedWarFrom;
import org.sobadfish.bedwar.player.PlayerData;

/**
 * @Author: StarTrek, ShaoqingG版权所有
 * @Date: 2023/9/17
 * @Time: 17:53
 * @Description:
 */
public class BedWarsInfoGui extends Command {
    public BedWarsInfoGui() {
        super("bwinfo","起床信息");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(commandSender instanceof Player){
            PlayerData data = BedWarMain.getDataManager().getData(commandSender.getName());
            BedWarFrom simple = new BedWarFrom("§c起床§e战争§r 信息显示",
                    "§f等级: "+data.getLevelString()+
                            "\n§f经验: "+data.getExpString(data.getExp())+
                            "\n§f下一级需要的经验: "+data.getExpString(data.getNextLevelExp())+
                            "\n§f总击杀: "+data.getFinalData(PlayerData.DataType.KILL)+
                            "\n§f总胜场: "+data.getFinalData(PlayerData.DataType.VICTORY)+
                            "\n§f总拆床数: "+data.getFinalData(PlayerData.DataType.BED_BREAK), DisPlayWindowsFrom.getId(51530,99810));
            simple.disPlay((Player) commandSender);
        }
        return false;
    }
}
