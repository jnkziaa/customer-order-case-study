/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      backgroundImage : {
        'discordHero': "url(../public/assets/discord.jpg')",
        'discord_background': "url(../public/assets/discord_background.jpg')",
      },
    },
  },
  plugins: [],
}