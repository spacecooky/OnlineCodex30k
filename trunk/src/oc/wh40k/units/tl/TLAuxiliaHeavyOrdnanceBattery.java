package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TLAuxiliaHeavyOrdnanceBattery extends Eintrag {

	AnzahlPanel artillery;
	OptionsUpgradeGruppe FK;
	OptionsEinzelZaehler crew;
	OptionsEinzelUpgrade shells;
	OptionsEinzelUpgrade camo;
	
	RuestkammerStarter rkTransport1;
	RuestkammerStarter rkTransport2;
	RuestkammerStarter rkTransport3;

	public TLAuxiliaHeavyOrdnanceBattery() {
		name= "Auxilia Heavy Ordnance Battery\n";
        grundkosten = 0;
        überschriftSetzen = true;
        

        add(ico = new oc.Picture("oc/wh40k/images/TLAuxiliaHeavyOrdnanceBattery.gif"));
		

        add(artillery = new AnzahlPanel(ID, randAbstand, cnt, "Artillery pieces", 1, 3, 0));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Earthshaker cannon", 75));
		ogE.addElement(new OptionsGruppeEintrag("Medusa siege gun", 100));
		add(FK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(crew = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Armsman crew", 4, 6));

		seperator();
		
		add(shells = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bastion breacher shells", 5));
		add(camo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 30));
		
		seperator();

		rkTransport1 = new RuestkammerStarter(ID, randAbstand, cnt, "TLTrojan", "Trojan");
		rkTransport1.initKammer(true);
		add(rkTransport1);
		

		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "TLTrojan", "Trojan");
		rkTransport2.initKammer(true);
		add(rkTransport2);
		

		rkTransport3 = new RuestkammerStarter(ID, randAbstand, cnt, "TLTrojan", "Trojan");
		rkTransport3.initKammer(true);
		add(rkTransport3);
		
		complete();

	}
	int aktivesBild = 0;

	//@OVERRIDE
	public void refreshen() {

		FK.alwaysSelected();
		
		FK.setModelle(artillery.getModelle());
		shells.setAktiv(FK.isSelected("Medusa siege gun"));
		shells.setPreis(artillery.getModelle() *5);
		camo.setPreis(artillery.getModelle() *30);
		
		rkTransport2.setAktiv(artillery.getModelle()>1);
		rkTransport3.setAktiv(artillery.getModelle()>2);
		
		if(rkTransport1.isSelected() || rkTransport2.isSelected() || rkTransport3.isSelected()){
			rkTransport1.setLegal(rkTransport1.isSelected());
			rkTransport2.setLegal(rkTransport2.isSelected());
			rkTransport3.setLegal(rkTransport3.isSelected());
		}

	}
}
