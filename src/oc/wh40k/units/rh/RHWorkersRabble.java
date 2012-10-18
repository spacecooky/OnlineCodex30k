package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RHWorkersRabble extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe weapon;
	OptionsZaehlerGruppe specWeapon;
	
	public RHWorkersRabble() {
		name = "Workers Rabble";
		grundkosten = 0;
		überschriftSetzen=true;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Workers", 20, 40, 4);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGPenalLegionSquad.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Worker with lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", "Worker with autogun", 0));
		add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 20));

		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Worker with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Worker with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Stubber", "Worker with heavy stubber", 10));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		
		complete();
	}

	@Override
	public void refreshen() {
		specWeapon.setMaxAnzahl(squad.getModelle()/10);
		weapon.setMaxAnzahl(squad.getModelle()-specWeapon.getAnzahl());
	}

}
