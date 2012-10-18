package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMTechmarine extends Eintrag {

	public SMTechmarine() {
		name = "Techmarine";
		grundkosten = 50;
        
        BuildaHQ.addToInformationVector("SMTechmarineOderMeister", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Techmarine.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servoharnisch", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiewaffe", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiehammer", 30));
		if(!OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class)) {
                    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Space Marine Bike", 35));
                }

		complete();
	}

	@Override
	public void refreshen() {
	}
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("SMTechmarineOderMeister", -1);
    }
    
}
