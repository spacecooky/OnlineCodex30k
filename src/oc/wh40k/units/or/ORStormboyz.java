package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class ORStormboyz extends Eintrag {

	AnzahlPanel Stormboyz;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe bossCC;
	OptionsEinzelUpgrade panzarüstung;
	OptionsEinzelUpgrade trophäenstange;
	OptionsEinzelUpgrade Zagstruk;
	OptionsEinzelUpgrade madDokCybork;
	
	boolean ZagstrukSelected = false;
	
	public ORStormboyz() {

		kategorie = 4;
		grundkosten = 0;

		Stormboyz = new AnzahlPanel(ID, randAbstand, cnt, "Stormboyz", 5, 20, 12);
		add(Stormboyz);

		add(ico = new oc.Picture("oc/wh40k/images/Stormboyz.gif"));

		seperator(15);

		add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss", 10));
		
		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));

		bossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE);
		add(bossCC);

		seperator(5);

		panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Panzarüstung", 5);
		add(panzarüstung);

		trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trophä'enstangä", 5);
		add(trophäenstange);

		seperator();

		add(Zagstruk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zagstruk", 85));
		
		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Stormboyz.getModelle()*5));

		complete();

	}

	@Override
	public void deleteYourself() {
		if(ZagstrukSelected) {
			BuildaHQ.setInformationVectorValue("ORZagstruk", -1);
		}
		super.deleteYourself();
	}
	
	//@OVERRIDE
	public void refreshen() {
		
		
		if (!boss.isSelected()) {
			bossCC.setAktiv(false);
			trophäenstange.setAktiv(false);
			panzarüstung.setAktiv(false);
			Zagstruk.setAktiv(true);
			
			// Unique entry: Zagstrukk
			if (ZagstrukSelected != Zagstruk.isSelected()) {
				ZagstrukSelected = !ZagstrukSelected;

				if (ZagstrukSelected) {
					BuildaHQ.addToInformationVector("ORZagstruk", 1);
				} else {
					BuildaHQ.addToInformationVector("ORZagstruk", -1);
				}
				RefreshListener.fireRefresh();
			}
			
		} else {
			bossCC.setAktiv(true);
			trophäenstange.setAktiv(true);
			panzarüstung.setAktiv(true);
			Zagstruk.setAktiv(false);
		}

		if (Zagstruk.isSelected()) {
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
		
		madDokCybork.setPreis(Stormboyz.getModelle()*5);

		Zagstruk.setLegal(BuildaHQ.getCountFromInformationVector("ORZagstruk") < 2 || !Zagstruk.isSelected());
	}
}
