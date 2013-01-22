package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ECLegionAttackBikeSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2, o3;
	OptionsUpgradeGruppe o1;

	public ECLegionAttackBikeSquadron() {
		name = "Legion Attack Bike Squadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Attack bike", "Attack bikes", 1, 5, 40);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Auto-cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		
		complete();
	}

	@Override
	public void refreshen() {
        
		o1.setPreis(0, squad.getModelle()*5);
				 
        o3.setMaxAnzahl(squad.getModelle());
		
		o2.setMaxAnzahl(squad.getModelle()-o3.getAnzahl());
		o2.setAnzahl(0, o3.getMaxAnzahl()-o3.getAnzahl());
	}

}
