package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;

public class TLLugftHuron extends Eintrag {

    public TLLugftHuron() {
        name = "Lugft Huron, The Tyrant of Badab";
        grundkosten = 235;

        BuildaHQ.addToInformationVector("TLEnableHonourGuard", 1);
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Cybot");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Ehrwürdiger Cybot");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Ironclad Cybot");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Protektorgarde");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Techmarine");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Terminator Sturmtrupp");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Terminator Trupp");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion of the Damned");

        add(ico = new oc.Picture("oc/wh40k/images/TLLugftHuron.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("TLEnableHonourGuard", -1);
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Cybot");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Ehrwürdiger Cybot");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Ironclad Cybot");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Protektorgarde");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Techmarine");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Terminator Sturmtrupp");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Terminator Trupp");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Legion of the Damned");
            
        super.deleteYourself();
       
           
        
    }
    
}
