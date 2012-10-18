package oc.wh40k.units.dm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DMCyborkSlashaMob extends Eintrag {

	AnzahlPanel cyborks;
	
	OptionsZaehlerGruppe cyborksNK;
	OptionsEinzelUpgrade stikkbombz;
	OptionsEinzelUpgrade eavyArmour;
	RuestkammerStarter painboy;

	public DMCyborkSlashaMob() {

		kategorie = 2;

		name = "Cybork Slashas";


		grundkosten = 0;



		cyborks = new AnzahlPanel(ID, randAbstand, cnt, "Cybork Slashas", 5, 10, 30);

		add(cyborks);


		add(ico = new oc.Picture("oc/wh40k/images/CyborkSlashas.gif"));

		seperator();


		ogE.addElement(new OptionsGruppeEintrag("Big Choppa", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power Klaw", 25));
		add(cyborksNK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, cyborks.getModelle()-1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("twin Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit-Kombi", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha-Kombi", 5));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		stikkbombz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombz", 1, cyborks.getModelle());

		add(stikkbombz);

		
		eavyArmour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Eavy Armour", 5, cyborks.getModelle());

		add(eavyArmour);
		
		seperator();

		
		painboy = new RuestkammerStarter(ID, randAbstand, cnt, "DMPainboy", "Painboy");
		painboy.initKammer();
		add(painboy);
		
		painboy.setAbwaehlbar(false);

		complete();



	}

	public void deleteYourself() { 
		
		super.deleteYourself();

	}
	
	@Override
	public void refreshen() {



		stikkbombz.setModelle(cyborks.getModelle());
		eavyArmour.setModelle(cyborks.getModelle());
		cyborksNK.setMaxAnzahl(cyborks.getModelle()-1);

	}
}
