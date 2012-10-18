package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMMeisterderSchmiede extends Eintrag {

	public SMMeisterderSchmiede() {
		name = "Meister der Schmiede";
		grundkosten = 100;
        
        BuildaHQ.addToInformationVector("SMTechmarineOderMeister", 1);
        BuildaHQ.addToInformationVector("SMMeisterderSchmiede", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMMeisterderSchmiede.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Konversionsstrahler", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));
		if(!OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class)) {
                    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Space Marine Bike", 35));
                }

        if(BuildaHQ.getCountFromInformationVector("SMMeisterderSchmiede") == 1) {
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ehrwürdiger Cybot");
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Cybot");
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ironclad-Cybot");
        }

		complete();
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        
        BuildaHQ.addToInformationVector("SMTechmarineOderMeister", -1);
        BuildaHQ.addToInformationVector("SMMeisterderSchmiede", -1);
        
        if(BuildaHQ.getCountFromInformationVector("SMMeisterderSchmiede") == 0) {
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ehrwürdiger Cybot");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Cybot");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ironclad-Cybot");
        }
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("SMArmenneusValthex") > 0) {
			setFehlermeldung("Armenneus Valthex!");
		}
	}

}
