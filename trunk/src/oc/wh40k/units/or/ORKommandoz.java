package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;

public class ORKommandoz extends Eintrag {

	AnzahlPanel Kommandoz;
	OptionsZaehlerGruppe KommandozFK;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe bossCC;
	OptionsEinzelUpgrade trophäenstange;
	OptionsEinzelUpgrade panzarüstung;
	OptionsEinzelUpgrade Snikrot;
	OptionsEinzelUpgrade madDokCybork;
	
	boolean SnikrotSelected = false;

	public ORKommandoz() {
		kategorie = 2;
		grundkosten = 0;

		Kommandoz = new AnzahlPanel(ID, randAbstand, cnt, "Kommandoz", 5, 15, 10);
		add(Kommandoz);

		add(ico = new oc.Picture("oc/wh40k/images/Kommandoz.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Brenna", 15));
		add(KommandozFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator(15);

		add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));
		add(bossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trophä'enstangä", 5));
		add(panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Panzarüstung", 5));

		seperator();

		add(Snikrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss Snikrot", 85));

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Kommandoz.getModelle()*5));

		
		complete();
	}

	
	@Override
	public void deleteYourself() {
		if(SnikrotSelected) {
			BuildaHQ.setInformationVectorValue("ORSnikrot", -1);
		}
		super.deleteYourself();
	}
	
	
	//@OVERRIDE
	public void refreshen() {
		
		
		if (!boss.isSelected()) {
			bossCC.setAktiv(false);
			trophäenstange.setAktiv(false);
			panzarüstung.setAktiv(false);
			Snikrot.setAktiv(true);
			
			// Unique entry: Snikrot
			if (SnikrotSelected != Snikrot.isSelected()) {
				SnikrotSelected = !SnikrotSelected;

				if (SnikrotSelected) {
					BuildaHQ.addToInformationVector("ORSnikrot", 1);
				} else {
					BuildaHQ.addToInformationVector("ORSnikrot", -1);
				}
				RefreshListener.fireRefresh();
			}
			
		} else {
			bossCC.setAktiv(true);
			trophäenstange.setAktiv(true);
			panzarüstung.setAktiv(true);
			Snikrot.setAktiv(false);
		}

		if (Snikrot.isSelected()) {
			boss.setAktiv(false);
		} else {
			boss.setAktiv(true);
		}
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Kommandoz.getModelle()*5 + (Snikrot.isSelected() ? 5 : 0));

		Snikrot.setLegal(BuildaHQ.getCountFromInformationVector("ORSnikrot") < 2 || !Snikrot.isSelected());
	}

}
