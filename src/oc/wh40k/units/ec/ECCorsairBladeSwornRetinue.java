package oc.wh40k.units.ec;

import java.util.Vector;
import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECCorsairBladeSwornRetinue extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade jetpacks;
    RuestkammerStarter rkViper;
    RuestkammerStarter rkFalcon;

    public ECCorsairBladeSwornRetinue() {
        name = "Corsair Blade Sworn Retinue\n";
        grundkosten = 0;
        überschriftSetzen = true;
        setEintragsCNT(0.0);
        
        BuildaHQ.addToInformationVector("ECCorsairBladeSwornRetinue", 1);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Blade Sworn", 2, 5, 14);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairBladeSwornRetinue.jpg"));
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasblaster", 2));
		ogE.addElement(new OptionsGruppeEintrag("Shuriken Catapult", 2));
		ogE.addElement(new OptionsGruppeEintrag("Fusion Pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        
        seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meltabombs", 10));
        add(jetpacks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Packs", 20));
        
        seperator();

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVenomKammer", "Corsair Venom");
		rkViper.initKammer();
		add(rkViper);

		rkFalcon = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairFalconKammer", "Corsair Falcon");
		rkFalcon.initKammer();
		add(rkFalcon);
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        
        rkFalcon.setAktiv(!rkViper.isSelected() && !jetpacks.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 4 && !rkFalcon.isSelected() && !jetpacks.isSelected());
        
        int jetpackPrinces = 0;
        Vector<Chooser> allPrinces = BuildaHQ.getChooserGruppe(1).getmC();
		for(Chooser chooser : allPrinces) {
			if(chooser.getEintrag() instanceof ECCorsairPrince && chooser.getEintrag().hasSpecialValue("Jetpack")) {
				jetpackPrinces += 1;
			}
		}
        
        int jetpackRetinues = 0;
        Vector<Chooser> allRetinues = BuildaHQ.getChooserGruppe(1).getmC();
		for(Chooser chooser : allRetinues) {
			if(chooser.getEintrag() instanceof ECCorsairBladeSwornRetinue && chooser.getEintrag().hasSpecialValue("Jetpack")) {
				jetpackRetinues += 1;
			}
		}
        
        boolean tooManyRetinues = BuildaHQ.getCountFromInformationVector("ECCorsairBladeSwornRetinue") > BuildaHQ.getCountFromInformationVector("ECCorsairPrince");
        
        if(tooManyRetinues) {
            setFehlermeldung("Retinue: 0-" + BuildaHQ.getCountFromInformationVector("ECCorsairPrince"));
        } else {
            if(jetpackPrinces != jetpackRetinues) {
                setFehlermeldung("Prüfe Jetpacks!");
            } else {
                setFehlermeldung("");
            }
        }
    }
    
	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("ECCorsairBladeSwornRetinue", -1);
	}
    
    @Override
    public boolean hasSpecialValue(String key) {
        if(key.equals("Jetpack"))
            return jetpacks.isSelected();
        
        return false;
    }

}
