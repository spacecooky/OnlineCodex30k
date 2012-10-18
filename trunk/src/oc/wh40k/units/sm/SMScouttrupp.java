package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMScouttrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade telion;
	RuestkammerStarter rkBoss;

    boolean telionSelected;

	public SMScouttrupp() {
		name = "Scouttrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Scouts", 5, 10, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMScouttrupp.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengew.", "Scharfschützengewehr", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", "Schwerer Bolter mit Höllenfeuer-Geschoss", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(5);

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tarnmäntel", -88 * 3));

		seperator();

		add(telion = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sergeant Telion", "Upgrade zum Sergeant Telion", 60));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMScoutSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		if(telion.isSelected()) {
			rkBoss.setAbwaehlbar(true);
			rkBoss.setAktiv(false);
		} else {
			rkBoss.setAbwaehlbar(false);
			rkBoss.setAktiv(true);
            if(!rkBoss.isSelected()) rkBoss.setSelected(true);
		}
		
		o1.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl() - telion.getSelectedAsInt()); // heavy weapon
		o2.setPreis(squad.getModelle() * 3);

        // Unique entry: Justicar telion
		boolean telionGlobal = ( BuildaHQ.getCountFromInformationVector("SMTelion") > 0 ? true : false );
		if(telionGlobal && !telionSelected) telion.setAktiv(false);
		else telion.setAktiv(true);

		if(telion.isSelected()) {
			telionSelected = true;
			BuildaHQ.setInformationVectorValue("SMTelion", 1);
		} else {
			if(telionSelected) {
				telionSelected = false;
				BuildaHQ.setInformationVectorValue("SMTelion", 0);
			}
		}
	}

    @Override
    public void deleteYourself() {
       super.deleteYourself();

       if(telion.isSelected()) {
           BuildaHQ.setInformationVectorValue("SMTelion", -1);
       }
    }

}
